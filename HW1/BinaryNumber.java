package HW1;

//Pranav Yalamala
//I pledge my honor that I have abided by the Stevens Honor System.

public class BinaryNumber {
    private int length;
    private int[] data;

    public BinaryNumber(int length){
        data = new int[length];
        this.length = length;
    }

    public BinaryNumber(String str){
        data = new int[str.length()];
        this.length = str.length();
        for(int i = 0; i < str.length(); i++){
            data[i] = java.lang.Character.getNumericValue(str.charAt(i));
        }
    }

    public int getLength(){
        return length;
    }

    public int[] getInnerArray(){
        return data;
    }

    public int getDigit(int index){
        if(index < 0 || index >= length){
            System.out.println("Index is out of bounds.");
            return -1;
        }
        else{
            return data[index];
        }
    }

    public int toDecimal(){
        int dec = 0;
        for(int i = 0; i < length; i++){
            if (data[i] == 1){
                dec += Math.pow(2, (double)(length - i - 1));
            }
        }
        return dec;
    }

    public void bitShift(int direction, int amount){
        if(direction == 1){
            if(amount > 0){
                BinaryNumber shift = new BinaryNumber(data.length - amount);
                for(int i = 0; i < shift.getLength(); i++){
                    shift.data[i] = data[i];
                }   
                this.data = shift.getInnerArray();
                this.length = shift.getLength();
            }
            else{
                System.out.println("Invalid: amount is negative.");
            }
        }
        else if(direction == -1){
            if(amount > 0){
                BinaryNumber shift = new BinaryNumber(data.length + amount);
                for(int i = 0; i < length; i++){
                    shift.data[i] = data[i];
                }
                this.data = shift.getInnerArray();
                this.length = shift.getLength();
            }
            else{
                System.out.println("Invalid: amount is negative.");
            } 
        }
        else{
            System.out.println("Invalid Direction.");
        }
    }

    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2){
        if(bn1.getLength() == bn2.getLength()){
            int[] bwor = new int[bn1.getLength()]; 
            for(int i = 0; i < bn1.getLength(); i++){
                if(bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1){
                    bwor[i] = 1;
                }
                else{
                    bwor[i] = 0;
                }
            }
            return bwor;
        }
        else{
            System.out.println("Invalid: Numbers are not the same length");
            return new int[1];
        }
    }

    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2){
        if(bn1.getLength() == bn2.getLength()){
            int[] bwand = new int[bn1.getLength()]; 
            for(int i = 0; i < bn1.getLength(); i++){
                if(bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1){
                    bwand[i] = 1;
                }
                else{
                    bwand[i] = 0;
                }
            }
            return bwand;
        }
        else{
            System.out.println("Invalid: Numbers are not the same length");
            return new int[1];
        }
    }

    public String toString(){
        String value = "";
        for(int i = 0; i < length; i++){
            value += String.valueOf(data[i]);
        }
        return value;
    }

    public void add(BinaryNumber aBinaryNumber){
        int difference = this.length - aBinaryNumber.getLength();
        if(difference > 0){
            String str = aBinaryNumber.toString();
            while(difference > 0){
                str = "0" + str;
                difference--;
            }
            aBinaryNumber = new BinaryNumber(str);
        }
        else if(difference < 0){
            difference = difference * -1;
            String str = this.toString();
            while(difference > 0){
                str = "0" + str;
                difference--;
            }
            BinaryNumber temp = new BinaryNumber(str);
            data = temp.getInnerArray();
            length = temp.getLength();
        }
        int Carry = 0;
        BinaryNumber result = new BinaryNumber(data.length);
        for(int i = this.length - 1; i >= 0; i--){
            if((Carry + data[i] + aBinaryNumber.data[i]) == 2){
                Carry = 1;
                result.data[i] = 0;
            }
            else if((Carry + data[i] + aBinaryNumber.data[i]) == 1){
                Carry = 0;
                result.data[i] = 1;
            }
            else if((Carry + data[i] + aBinaryNumber.data[i]) == 0){
                Carry = 0;
                result.data[i] = 0;
            }
            else if((Carry + data[i] + aBinaryNumber.data[i]) == 3){
                Carry = 1;
                result.data[i] = 1;
            }
        }
        if(Carry == 1){
            String str = "1" + result.toString();
            result = new BinaryNumber(str);
        }
        data = result.getInnerArray();
        length = result.getLength();


    }

    public static void main(String[] args){
        BinaryNumber bn1 = new BinaryNumber(4);
        BinaryNumber bn2 = new BinaryNumber("1011");

        System.out.println(bn1.getLength());
        System.out.println(bn2.getLength());

        String a1 = "";
        for(int i = 0; i < bn1.getLength(); i++){
            a1 += String.valueOf(bn1.getInnerArray()[i]);
        }
        String a2 = "";
        for(int i = 0; i < bn2.getLength(); i++){
            a2 += String.valueOf(bn1.getInnerArray()[i]);
        }
        
        System.out.println(a1);
        System.out.println(a2);

        System.out.println(bn1.getDigit(3));
        System.out.println(bn2.getDigit(3));

        System.out.println(bn1.toDecimal());
        System.out.println(bn2.toDecimal());

        int[] bwor = BinaryNumber.bwor(bn1, bn2);
        int[] bwand = BinaryNumber.bwand(bn1, bn2);
        String b1 = "";
        for(int i = 0; i < bwor.length; i++){
            b1 += String.valueOf(bwor[i]);
        }
        String b2 = "";
        for(int i = 0; i < bwand.length; i++){
            b2 += String.valueOf(bwand[i]);
        }

        System.out.println(b1);
        System.out.println(b2);

        System.out.println(bn1.toString());
        System.out.println(bn2.toString());

        bn2.bitShift(1, 2);
        System.out.println(bn2.toString());
        bn2.bitShift(-1, 2);
        System.out.println(bn2.toString());

        bn1 = new BinaryNumber("11000");
        bn2 = new BinaryNumber("11111");
        bn1.add(bn2);
        System.out.println(bn1.toString());
        

    }


    
}
