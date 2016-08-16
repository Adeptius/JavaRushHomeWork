package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;


import javax.swing.*;
import javax.swing.undo.UndoManager;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Leonid on 19.01.2016.
 */

public class View extends JFrame implements ActionListener
{




    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public View()    {
       try
       {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }
       catch (Exception e)
       {
        ExceptionHandler.log(e);
       }

   }
//    Задание 18.
//
//    Реализуй метод selectedTabChanged() представления. Этот метод вызывается, когда произошла
//    смена выбранной вкладки. Итак:
//        18.1.	Метод должен проверить, какая вкладка сейчас оказалась выбранной.
//    18.2.	Если выбрана вкладка с индексом 0 (html вкладка), значит нам нужно получить текст из
//    plainTextPane и установить его в контроллер с помощью метода setPlainText.
//        18.3.	Если выбрана вкладка с индексом 1 (вкладка с html текстом), то необходимо получить
//    текст у контроллера с помощью метода getPlainText() и установить его в панель
//    plainTextPane.
//    18.4.	Сбросить правки (вызвать метод resetUndo представления).

    public void selectedTabChanged()
    {
       if ( tabbedPane.getSelectedIndex()==0)   {
           controller.setPlainText(plainTextPane.getText());
       } else if (tabbedPane.getSelectedIndex()==1)     {
        plainTextPane.setText(controller.getPlainText());
    }
        resetUndo();
    }


    public void showAbout()  {
        JOptionPane.showMessageDialog (getContentPane() ,"Hello from Leonidius", "about", JOptionPane.INFORMATION_MESSAGE);

    }
    public void update ()   {
        htmlTextPane.setDocument(controller.getDocument());
    }

public void selectHtmlTab()
{
    tabbedPane.setSelectedIndex(0);
    resetUndo();

}


    public boolean isHtmlTabSelected()  {
       return tabbedPane.getSelectedIndex()==0;
    }



    public void resetUndo() {
        undoManager.discardAllEdits();
    }


    public void undo () {
        try
        {
            undoManager.undo();
        } catch (RuntimeException e)    {
            ExceptionHandler.log(e);
        }
    }
    public void redo()  {
        try
        {
            undoManager.redo();
        } catch (RuntimeException e)    {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void initMenuBar()  {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);


    }




    public void initEditor()    {
    htmlTextPane.setContentType("text/html");
    JScrollPane scrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML",scrollPaneHTML);
        JScrollPane scrollPaneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", scrollPaneText);
        tabbedPane.setPreferredSize(new Dimension(240,260));
        TabbedPaneChangeListener paneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(paneChangeListener);
       Container container = getContentPane();
        container.add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui()   {
        initMenuBar();
        initEditor();
        pack();
    }

//    Задание 19.
//
//    Реализуем метод actionPerformed(ActionEvent actionEvent) у представления, этот метод
//    наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню, у
//    которых наше представление указано в виде слушателя событий.
//        19.1.	Получи из события команду с помощью метода getActionCommand(). Это будет
//    обычная строка. По этой строке ты можешь понять какой пункт меню создал данное
//    событие.
//    19.2.	Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом
//    пункте и далее, если необходимого метода в контроллере еще нет - создай заглушки.
//        19.3.	Если это команда "Открыть", вызови метод openDocument().
//        19.4.	Если "Сохранить", то вызови saveDocument().
//        19.5.	Если "Сохранить как..." - saveDocumentAs().
//        19.6.	Если "Выход" - exit().
//        19.7.	Если "О программе", то вызови метод showAbout() у представления.
//    Проверь, что заработали пункты меню Выход и О программе.

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        switch (action) {
            case ("Новый"):
                controller.createNewDocument();
                break;
            case ("Открыть"):
                controller.openDocument();
                break;
            case ("Сохранить"):
                controller.saveDocument();
                break;
            case ("Сохранить как..."):
                controller.saveDocumentAs();
                break;
            case ("Выход"):
                controller.exit();
                break;
            case ("О программе"):
                showAbout();
                break;

        }


    }
    public void init()  {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);

        setVisible(true);


    }


    public Controller getController()
    {
        return controller;
    }

    public void exit () {
        controller.exit();
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }



    public boolean canUndo()
    {
        return undoManager.canUndo();
    }
    public boolean canRedo ()  {
        return undoManager.canRedo();
    }
}
