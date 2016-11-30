package com.company;

import java.util.Scanner;

/**
 * Created by asus on 2016/11/30.
 */
public class ScannerTest {
    public static void main(String arg[])
    {


                Scanner s = new Scanner(System.in);
                System.out.println("ÇëÊäÈë×Ö·û´®£º");
                while (true) {
                    String line = s.nextLine();
                    if (line.equals("exit")) break;
                    System.out.println(">>>" + line);
                }
            }

    }

