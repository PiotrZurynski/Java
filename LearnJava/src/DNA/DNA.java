package DNA;

public class DNA{
    public static void main(String[] args){
        //  -. .-.   .-. .-.   .
        //    \   \ /   \   \ /
        //   / \   \   / \   \
        //  ~   `-~ `-`   `-~ `-
        String dna1="ATGCGATACGCTTGA";
        String dna2="ATGCGATACGTGA";
        String dna3="ATTAATATGTACTGA";
        String dna=dna3;
        int length=dna.length();
        System.out.println(length);
        int indexATG=dna.indexOf("ATG");
        System.out.println(indexATG);
        int indexTGA=dna.indexOf("TGA");
        System.out.println(indexTGA);
        if(dna.indexOf("ATG")==0 && dna.indexOf("TGA")==dna.length()-3){
            if(dna.length()%3==0){
                String protein=dna;
                System.out.println(protein);
            }else{
                System.out.println("No protein");
            }
        }else{
            System.out.println("No protein");
        }
    }
}

