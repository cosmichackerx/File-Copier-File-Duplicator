import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

class bin{

    void binary(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name");
        String fileName = sc.nextLine();

        try(FileInputStream fis = new FileInputStream(fileName);){

            Scanner out = new Scanner(System.in);
            System.out.println("Enter the name of output file");
            String outFileName = out.nextLine();
            FileOutputStream fos = new FileOutputStream(outFileName);

            int i;
            while((i=fis.read())!=-1){
                fos.write(i);
            }
            System.out.println("Successfully wrote to the file");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}



public class Main {
    public static void main(String[] args) {

        bin b = new bin();
        b.binary();
        b.binary();

    }
}
