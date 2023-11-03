
import java.util.*;
import java.lang.*;
import java.io.*;
public class aok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){
        System.out.println("1. Biner ke Desimal");
        System.out.println("2. Desimal ke Biner");
        System.out.println("3. Biner ke Hexa");
        System.out.println("4. Hexa ke Biner");
        System.out.println("5. Desimal ke Hexa");
        System.out.println("6. Hexa ke Desimal");
        System.out.println("0. Selesai");
        System.out.print("Pilih konversi : ");
        int pilih = sc.nextInt();
        if(pilih == 1){ //Biner ke Desimal
            System.out.print("Masukkan bilangan biner : ");
            String input = sc.next();
            if(input.matches("[01]+")){
                int len = input.length();
                int pow = len-1;
                int sum = 0;
                for(int i=0;i<len;i++){
                    sum = sum + (int)(Character.getNumericValue(input.charAt(i))*Math.pow(2, pow));
                    System.out.println("perhitunan "+ (len-i) + " = " +(Character.getNumericValue(input.charAt(i)))*Math.pow(2, pow));
                    pow--;
                }
                System.out.println("Nilai desimal = "+sum);
            } 
            else{
                System.out.println("Invalid binary input.");
            }
        }
        else if(pilih == 2){ //Desimal ke Biner
            System.out.print("Masukkan bilangan desimal : ");
            String input = sc.next();
            if(input.matches("[0-9]+")){
                int pow = 0;
                int val = Integer.valueOf(input);
                while((val-Math.pow(2,pow))>=0){
                    System.out.println("perhitungan ke "+pow+" = "+val+" - "+Math.pow(2,pow)+" = "+(val-Math.pow(2,pow)));
                    pow++;
                }
                pow--;
                int len = pow;
                String result = "";
                System.out.println("-------");
                while(val>0){
                    if((val-Math.pow(2,pow)) >= 0){
                        System.out.println("perhitungan ke "+pow+" = "+val+" - "+Math.pow(2,pow)+" = "+(val-Math.pow(2,pow)));
                        val = (int)(val-Math.pow(2,pow));
                        result += "1";
                        System.out.println(result);
                        pow--;
                    }
                    else{
                        result += "0";
                        System.out.println("perhitungan ke "+pow+" = "+val+" - 0"+" = "+(val-0));
                        System.out.println(result);
                        pow--;
                    }
                }
                for(int i=result.length();i<=len;i++){
                    result += "0";
                }
                System.out.println("value = "+val);
                System.out.println("pow = "+pow);
                System.out.println("Nilai biner = "+result);
            } 
            else{
                System.out.println("Invalid decimal input.");
            }
        }
        else if(pilih == 3){ //Biner ke Hexa
            String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
            System.out.print("Masukkan bilangan biner : ");
            String input = sc.next();
            if(input.matches("[01]+")){
                int len = input.length();
                int div = len/4;
                int sum = 0;
                String result = "";
                for(int i=0;i<div;i++){
                    for(int p=0;p<4;p++){
                        int pow = p;
                        int index=(len-(p+(i*4)))-1;
                        System.out.println("index "+index+" : "+ (int)(Character.getNumericValue(input.charAt((len-(p+(i*4)))-1))*Math.pow(2, pow)));
                        sum = sum + (int)(Character.getNumericValue(input.charAt((len-(p+(i*4)))-1))*Math.pow(2, pow));
                    }
                    result = hex[sum] + result;
                    System.out.println("result = "+result);
                    sum = 0;
                }
                for(int p=0;p<len%4;p++){
                    int index=p;
                    System.out.println("index "+index+" : "+ (int)(Character.getNumericValue(input.charAt(p))*Math.pow(2, len%4-p-1)));
                    sum = sum + (int)(Character.getNumericValue(input.charAt(p))*Math.pow(2, len%4-p-1));
                }
                result = hex[sum] + result;
                System.out.println("result = "+result);
            } 
            else{
                System.out.println("Invalid binary input.");
            }
        }
        else if(pilih == 4){ //Hexa ke Biner
            System.out.print("Masukkan bilangan hexa : ");
            String input = sc.next();
            String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
            String[] bin = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
            if(input.matches("[0-9A-Fa-f]+")){
                int len = input.length();
                String result = "";
                for(int i=len-1;i>=0;i--){
                    for(int p=0;p<16;p++){
                        if(String.valueOf(input.charAt(i)).equals(hex[p])){
                            System.out.println("current : "+String.valueOf(input.charAt(i))+"   val : "+bin[p]);
                            result = bin[p] + result;
                            System.out.println("result = "+result);
                        }
                    }
                }
                System.out.println("result = "+result);
                result = result.replaceFirst("^0+(?!$)", "");
                System.out.println("result = "+result);
            } else{
                System.out.println("Invalid hexadecimal input.");
            }
        }
        else if(pilih == 5){ //Desimal ke Hexa
            System.out.print("Masukkan bilangan desimal : ");
            String input = sc.next();
            String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
            String result = "";
            if(input.matches("[0-9]+")){
                int val = Integer.valueOf(input);
                while(val>15){
                    System.out.println("val = "+val+" / 16");
                    int sisa = val % 16;
                    result = hex[sisa] + result;
                    val = val/16;
                    System.out.println("val = "+val);
                    System.out.println("sisa = "+(sisa+(val*16))+" modulo 16");
                    System.out.println("sisa = "+sisa);
                    System.out.println("result = "+result+"\n");
                }
                result = hex[val] + result;
                System.out.println("val = "+val);
                System.out.println("result = "+result);
            } 
            else{
                System.out.println("Invalid decimal input.");
            }
        }
        else if(pilih == 6){ //Hexa ke Desimal
            System.out.print("Masukkan bilangan hexa : ");
            String input = sc.next();
            String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
            int[] des = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            int sum = 0;
            if(input.matches("[0-9A-Fa-f]+")){
                int len = input.length();
                for(int i=len-1;i>=0;i--){
                    for(int p=0;p<16;p++){
                        if(String.valueOf(input.charAt(i)).equals(hex[p])){
                            System.out.println("current : "+String.valueOf(input.charAt(i))+"   val : "+(des[p]*Math.pow(16, len-(i+1))));
                            sum = sum + (int)(des[p]*Math.pow(16, len-(i+1)));
                        }
                    }
                }
                System.out.println("sum : " + sum);
            } else{
                System.out.println("Invalid hexadecimal input.");
            }
        }
        else if(pilih == 0){
            loop = false;
        }
        else{
            System.out.println("pilihan invalid");
        }
        }
    } 
}
    

