package Language;

    public class Language{
        protected String name;
        protected int numSpeakers;
        protected String regionsSpoken;
        protected String wordOrder;
        public Language(String name,int numSpeakers,String regionsSpoken,String wordOrder){
            this.name=name;
            this.numSpeakers=numSpeakers;
            this.regionsSpoken=regionsSpoken;
            this.wordOrder=wordOrder;
        }
        public void getInfo(){
            System.out.println(name+ " is spoken by "+numSpeakers+ " people mainly in "+regionsSpoken+".\nThe language follows the word order: "+wordOrder);
        }
        public static void main(String[] args){
            Language polish=new Language("Polski",38000000,"Poland","subject-verb-object");
            polish.getInfo();
            Mayan mayan=new Mayan("Mayan",2);
            mayan.getInfo();
            SinoTibetan mandarin=new SinoTibetan("Mandarin Chinese",2);
            SinoTibetan burmese= new SinoTibetan("Burmese",3);
            mandarin.getInfo();
            burmese.getInfo();

        }
    }

