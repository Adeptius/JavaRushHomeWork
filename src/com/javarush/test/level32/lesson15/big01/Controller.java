package com.javarush.test.level32.lesson15.big01;

        import javax.swing.*;

        import javax.swing.text.BadLocationException;
        import javax.swing.text.html.HTMLDocument;
        import javax.swing.text.html.HTMLEditorKit;
        import java.io.*;



/**
 * Created by Leonid on 19.01.2016.
 *
 */
public class Controller
{
    private File currentFile;
    private View view;
    private HTMLDocument document;

     public Controller(View view)
    {
        this.view = view;
    }


    public void init()  {
        createNewDocument();
    }
//    Задание 23.
//
//        23.1.	Напишем метод для сохранения открытого файла saveDocument(). Метод должен
//    работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а
//    использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().
//        23.2.	Пришло время реализовать метод openDocument(). Метод должен работать
//    аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла.
//    Подсказка: Обрати внимание на имя метода для показа диалогового окна.
//    Когда файл выбран, необходимо:
//        23.2.1.	Установить новое значение currentFile.
//        23.2.2.	Сбросить документ.
//        23.2.3.	Установить имя файла в заголовок у представления.
//    23.2.4.	Создать FileReader, используя currentFile.
//    23.2.5.	Вычитать данные из FileReader-а в документ document с помощью объекта класса
//    HTMLEditorKit.
//    23.2.6.	Сбросить правки (вызвать метод resetUndo представления).
//        23.2.7.	Если возникнут исключения - залогируй их и не пробрасывай наружу.
//    Проверь работу пунктов меню Сохранить и Открыть.

    public void openDocument()
    {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Open File");
        int resultOfChoosing = fileChooser.showOpenDialog(view);
        if (resultOfChoosing==JFileChooser.APPROVE_OPTION)  {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile))   {
                HTMLEditorKit editorKit = new HTMLEditorKit();
                editorKit.read(reader,document,0);
                view.resetUndo();
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument()  {
        if (currentFile==null)  {
            saveDocumentAs();
        } else
        {
            view.selectHtmlTab();
            try (FileWriter writer = new FileWriter(currentFile))   {
                HTMLEditorKit editorKit = new HTMLEditorKit();
                editorKit.write(writer, document,0, document.getLength());
            } catch (Exception e)   {
                ExceptionHandler.log(e);
            }
        }
    }


    public void saveDocumentAs()
    {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Save File");
        int clientDecision = fileChooser.showSaveDialog(view);
        if (clientDecision == JFileChooser.APPROVE_OPTION)  {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter writer = new FileWriter(currentFile))
            {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.write(writer,document,0,document.getLength())   ;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }

    public String getPlainText()    {

        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit =new HTMLEditorKit();

        try
        {
            htmlEditorKit.write(stringWriter,document,0,document.getLength());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
       return stringWriter.toString();

    }

    public void setPlainText (String text)  {
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();

        try {
            htmlEditorKit.read(reader,document,0);
        }

        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void resetDocument() {
        if (document!=null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void exit () {
        System.exit(0);
    }




    public HTMLDocument getDocument()
    {
        return document;
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();




    }








}
