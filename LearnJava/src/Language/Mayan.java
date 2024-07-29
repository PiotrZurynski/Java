package Language;


    public class Mayan extends Language{
        public Mayan(String name,int numSpeakers){
            super(name,numSpeakers,"Central America","verb-object-subject");
        }
        @Override
        public void getInfo(){
            System.out.println(name+" is spoken by "+numSpeakers+" people mainly in "+ regionsSpoken+".\nThe language follows the word order: "+ wordOrder+"\nFun fact: "+name+ " is an ergative language");
        }

    }

