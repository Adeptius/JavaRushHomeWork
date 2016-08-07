package My;


import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println("pnputil.exe /delete-driver oem" + i + ".inf");
        }
    }
}
