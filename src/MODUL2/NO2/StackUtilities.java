package MODUL2.NO2;

// membuat class StackUtilities dengan public modifier
public class StackUtilities {
    // membuat fungsi untuk mengecek prioritas operator
    static int getPriority(char ch) {
        // mengembalikan nilai 1 jika merupakan operator berikut
        if (ch == '-' || ch == '+')
            return 1;
        // mengembalikan nilai 2 jika merupakan operator berikut
        else if (ch == '*' || ch == '/')
            return 2;
        // mengembalikan nilai 3 jika merupakan operator berikut
        else if (ch == '^')
            return 3;

        // mengembalikan nilai 0 bukan jika merupakan operator. karena seluruh operator sudah di cek di atas
        return 0;
    }

    // membuat fungsi untuk merubah infix to prefix dengan parameter expression (infix)
    static String toPreFix(String expression){
        //inisiasi penyimpanan dengan tipe data stack. digunakan untuk menyimpan operator
        Stack stack = new Stack();
        //inisiasi penyimpanan dengan tipe data string. digunakan untuk menyimpan operand
        String result = "";


        // expression akan direverse karena dikerjain dari belakang. reverse nya butuh stringbuilder
        StringBuilder input = new StringBuilder(expression);
        // mereverse atau membalik nilai dari input
        input.reverse();

        // membuat array charArray agar bisa melakukan looping per karakter dari string
        char [] charArray = new String(input).toCharArray();
        // melakukan looping sebanyak karakter di dalam string
        for (int i = 0; i < charArray.length; i++) {
            // jika karakter yang di cek sama dengan (
            if (charArray[i] == '(') {
                // maka yang di input adalah ) *ingat, ini direverse*
                charArray[i] = ')';
                // menambah jumlah i untuk perulangan berikutnya
                i++;
            }
            // jika karakter yang di cek sama dengan )
            else if (charArray[i] == ')') {
                // maka yang di input adalah ( *ingat, ini direverse*
                charArray[i] = '(';
                // menambah jumlah i untuk perulangan berikutnya
                i++;
            }
        }

        // melakukan perulangan sebanyak isi charArray dan di asosiasikan ke variabel c yang ber tipe data char
        for (char c : charArray) {
            //mengecek apakah char ini adalah operand atau bukan, menurut fungsi getprioity, kalau operator 1-3, kalau operand 0
            // jika merupakan operator maka :
            if (getPriority(c) > 0) {
                // membandingkan operator yang disimpan dalam stack. kalau operator yang tersimpan lebih tinggi, langsung di pop.
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    result += stack.pop();
                }
                // setelah itu char yg lebih rendahnya dimasukkan
                stack.push(c);
            } else if (c == ')') {
                // jika merupakan )
                // menyimpan hasil pop ke dalam karakter char
                char temp = stack.pop();
                // mengecek apakah temp tidak sama dengan ( . di lakukan perulangan
                // jika terpenuhi akan melakukan pop sebanyak isi operator yang didalam kurung
                while (temp != '(') {
                    // dika kondisi terpenuhi, result akan ditambahkan hasil dari temp
                    result  += temp;
                    // stack akan di pop lagi
                    temp = stack.pop();
                }
            } else if (c == '(') {
                // jika c senilai dengan ( maka akan dimasukkan dalam stack
                stack.push(c);
            } else {
                // jika bukan operator dan bukan ( dan ) maka dianggap operand dan langsung dimasukkan kedalam result
                result  += c;
            }
        }

        // melakukan perulangan sebanyak izi stack
        for (int i = 0; i <= stack.size ; i++) {
            // seluruh isi stack akan dimasukkan kedalam result
            result  += stack.pop();
        }

        // membuat string builder untuk melakukan reverse
        StringBuilder resultReversed = new StringBuilder(result).reverse();
        // mengembalikan nilai dari haril reverse sambil mengubahnya ke string dengan method toString()
        return resultReversed.toString();
    }

    // fungsi untuk merubah infix to postfix dengan parameter infix
    private static String toPostfix(String infix) {
        // membuat penampungan untuk operator dengan tipe data stack
        Stack operators = new Stack();
        // membuat variabel temp bertipe data char untuk penyimpanan sementara karakter
        char temp;
        // membuat penampung untuk hasil operasi toPostfix dengan nama postfix dengan tipe data string
        String postfix = "";
        // melakukan perulangan sebanyak karakter di dalam parameter
        for (int i = 0; i < infix.length(); ++i){
            // memasukkan karakter dari parameter dengan index ke - i kedalam temp
            temp = infix.charAt(i);
            // mengecek apakah karakter tersebut adalah merupakan karakter ( operand )
            if (Character.isLetter(temp))
                // jika iya maka akan dimasukkan kedalam postfix langsung
                postfix = postfix + temp;
            // jika merupakan (
            else if (temp == '(') {
                //  maka akan dimasukkan kedalam stack operator
                operators.push(temp);
            }
            // jika merupakan )
            else if (temp == ')') {
                // maka akan melakukan perulangan sampai menemukan (
                // dan setiap perulangan, isi dari stack akan di pop dan ditambah ke postfix
                // maksudnya adalah akan memasukkan seluruh operator dalam kurung kedalam postfix
                while (operators.peek() != '(') {
                    // memasukkan operator yang di pop ke postfix
                    postfix = postfix + operators.pop();
                }
                // menhapus ( dari stack operator
                operators.pop();
            }
            // jika merupakan operand maka
            else {
                // melakukan perulangan jika prioritas temp  lebih  kecil daripada operator sebelumnya, maka operator sebelumnya akan di pop sampai menemukan operator yang lebih kecil dari temp
                while (!operators.isEmpty() && !(operators.peek() == '(') && getPriority(temp) <= getPriority(operators.peek())){
                    // menambahkan operator temp yang di pop kedalam postfix
                    postfix = postfix + operators.pop();
                }
                // menambahkan operator kedalam stack
                operators.push(temp);
            }
        }
        // ketika operator tidak kosong setelah perulangan tadi, maka akan dilakukan perulangan untuk mengeluaarkan sisanya
        while (!operators.isEmpty()){
            // memasukkan operator yang di pop kedalam postfix
            postfix = postfix + operators.pop();
        }
        // mengembalikan nilai postfix
        return postfix;
    }


    public static void main(String[] args) {
        // inisiasi infix dengan nilai yang akan di uji coba dengan tipe data string
        String infix = "(A+B)*C-(D-E)*(F+G)";
        // menginisiasi variabel postfix dengan nilai hasil dari fungsi toPostix dengan argumen infix
        String postfix = toPostfix(infix);
        // menginisiasi variabel prefix dengan nilai hasil dari fungsi toPrefix dengan argumen infix
        String prefix = toPreFix(infix);
        // melakukan pencetakan hasil dari operasi di atas
        System.out.println("== Convert Infix to Postfix and Prefix ==");
        System.out.println("-----------------------------------------");
        System.out.println("Notasi Infix : " + infix);
        System.out.println("-----------------------------------------");
        System.out.println("Notasi Postfix : " + postfix);
        System.out.println("Notasi Prefix : " + prefix);
        System.out.println("-----------------------------------------");
    }


}
