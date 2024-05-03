import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MySecondClass2 {
    public static void main(String[] args) throws IOException {

        //1.Выведите числа от 0 до миллиона.
        int q = 0;
        while(q <= 1000000){
            System.out.println(q);
            q++;
        }

        //2.Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5...101.5.
        double w = 1.5;
        while(w <= 101.5){
            System.out.println(w);
            w = w + 0.5;
        }

        //3.Выведите латинский алфавит от a до z.
        char e = 'a';
        while(e <= 'z'){
            System.out.println(e);
            e++;
        }

        //4.Выведите русский алфавит от а до я.
        char r = 'а';
        while(r <= 'я'){
            System.out.println(r);
            r++;
        }

        //5.Создайте 10 тысяч файлов.
        int t = 1;
        while(t <= 10000){
            File file = new File("files/" + t);
            file.createNewFile();
            t++;
        }

        //6.В файле две строки: секретное слово и подсказка. Вывести подсказку.
        // Считывать строку за строкой, пока игрок не отгадает секретное слово(не введёт его).
        InputStream stream = new FileInputStream("file1.txt");
        Scanner scan1 = new Scanner(stream);
        String y = scan1.nextLine();
        System.out.println("Подсказка: " + y);
        String y1 = scan1.nextLine();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите секретное слово:");
        String ySec = scanner.nextLine();

        while(! ySec.equals(y1)){
            System.out.print("Не угадали, попробуйте ещё раз:");
            ySec = scanner.nextLine();
        }
        System.out.println("Вы угадали!");

        //7.Предыдущее задание, но если пользователь ввел хотя бы часть слова верно, то писать: горячо.
        // (Проверять с помощью str.contains).
        InputStream stream1 = new FileInputStream("file1.txt");
        Scanner scan11 = new Scanner(stream1);
        String yY = scan11.nextLine();
        System.out.println("Подсказка: " + y);
        String yY2 = scan11.nextLine();
        System.out.print("Введите секретное слово:");
        String ySec22 = scanner.nextLine();

        while(! ySec22.equals(y1)){
            if(ySec22.contains("Qwerty")){
                System.out.println("Горячо");
                System.out.print("Попробуйте ещё раз:");//сделал эту часть слова, думаю так логичнее будет,
                                         // конечно при желании можно добавить ещё if и сделать разные части слова...
                } else{
                System.out.print("Не угадали, попробуйте ещё раз:");
            }
            ySec22 = scanner.nextLine();
        }
        System.out.println("Вы угадали!");

        //8.Первый игрок сохраняет слово и подсказку в первый файл, второй игрок во второй.
        // Игра начинается, выводятся подсказки, игроки по-очереди пытаются отгадать слово противника.
        System.out.print("1 игрок, введите подсказку:");
        String u1 = scanner.nextLine();
        System.out.print("1 игрок, введите своё слово:");
        String u11 = scanner.nextLine();
        System.out.print("2 игрок, введите подсказку:");
        String u2 = scanner.nextLine();
        System.out.print("2 игрок, введите своё слово:");
        String u22 = scanner.nextLine();

        PrintWriter writer1 = new PrintWriter("file1player.txt");
        writer1.println(u1);
        writer1.println(u11);
        writer1.close();

        PrintWriter writer2 = new PrintWriter("file2player.txt");
        writer2.println(u2);
        writer2.println(u22);
        writer2.close();

        InputStream stream11 = new FileInputStream("file1player.txt");
        Scanner scan15 = new Scanner(stream11);
        String i1 = scan15.nextLine();
        System.out.println("Подсказка для 2 игрока: " + i1);
        String i11 = scan15.nextLine();
        InputStream stream2 = new FileInputStream("file2player.txt");
        Scanner scan2 = new Scanner(stream2);
        String i2 = scan2.nextLine();
        System.out.println("Подсказка для 1 игрока: " + i2);
        String i22 = scan2.nextLine();

        System.out.println("Начинает 1 игрок:");
        System.out.print("1 игрок, угадайте секретное слово:");
        String iSec1 = scanner.nextLine();

        while (!iSec1.equals(i22)) {
            System.out.print("Не угадали, очередь 2 игрока:");
            String iSec2 = scanner.nextLine();
            if (!iSec2.equals(i11)) {
                System.out.print("Не угадали, снова 1 игрок:");
                iSec1 = scanner.nextLine();
            } else{
                System.out.println("2 игрок угадал слово!");
                break;
            }


        }
        if(iSec1.equals(i22)) {
            System.out.println("1 игрок угадал слово!");

            System.out.print("2 игрок, введите слово:");
            String iSec2 = scanner.nextLine();
            while (!iSec2.equals(i11)) {
                System.out.print("Не угадали, попробуйте ещё раз:");
                iSec2 = scanner.nextLine();
            }
            System.out.println("2 игрок угадал слово!");

        } else {
            System.out.print("1 игрок, введите слово:");
            iSec1 = scanner.nextLine();
            while (!iSec1.equals(i22)) {
                System.out.print("Не угадали, попробуйте ещё раз:");
                iSec1 = scanner.nextLine();
            }
            System.out.println("1 игрок угадал слово!");

        }
        System.out.println("Оба игрока отгадали слова! Игра завершена.");
        //Скажите, пожалуйста, как-то проще можно было решить данную задачу? Или это нормальное решение?


        //9.Пока пользователь не введёт строку, содержащую пробел, считывайте строки и выводите их первые буквы.
        System.out.print("Введите строку:");
        String o = scanner.nextLine();
        char o1 = ' ';

        while (!o.contains(String.valueOf(o1))){
            System.out.print("Повторите ввод:");
            o = scanner.nextLine();
        }
        System.out.println("Строка содержит пробел.");

        //10.Пользователь вводит полный путь и название файла.
        // Пока пользователь не ввел путь к существующему файлу, повторять ввод.
        // Проверить, что файл существует, можно так: File f = new File(); boolean isExists = f.exists();
        System.out.print("Введите название файла:");
        File p1 = new File(scanner.nextLine());
        boolean isExists = p1.exists();

        while (!(isExists = p1.exists())){
            System.out.println("Попробуйте ещё раз:");
            p1 = new File(scanner.nextLine());
        }
        System.out.println("Всё введено верно!");
        //Путь к файлу был такой: C:\Users\mrles\IdeaProjects\Test-2-and-2\Fiilee.txt


    }
}
