package songsPlaylist;

import java.util.Arrays;
import java.util.ArrayList;
class Playlist {
    public static void main(String[] args){
        String[] favoriteSongs=new String[10];
        favoriteSongs[0]="Queen - Bohemian Rhapsody";
        favoriteSongs[1]="AC/DC - Highway to hell";
        favoriteSongs[2]="Perfect - Perfect";
        favoriteSongs[3]="TOTO - Africa";
        favoriteSongs[4]="Metallica - Master of Puppets";
        favoriteSongs[5]="Eminem - Underground";
        favoriteSongs[6]="Sanah - hip hip hura!";
        favoriteSongs[7]="Travis Scoot - Skitzo";
        favoriteSongs[8]="Ye - Kid see ghosts";
        favoriteSongs[9]="PRO8L3M - W domach z betonu";
        System.out.println(favoriteSongs[0]);
        System.out.println(favoriteSongs[1]);
        System.out.println(favoriteSongs[2]);
        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("Avicii - Wake me up");
        desertIslandPlaylist.add("Bon Jovi - You give love a bad name");
        desertIslandPlaylist.add("Kesha - TiK ToK");
        desertIslandPlaylist.add("Nirvana - Smells Like Teen Spirit");
        desertIslandPlaylist.add("Metallica - Enter Sandman");
        System.out.println(desertIslandPlaylist);
        desertIslandPlaylist.addAll(Arrays.asList(favoriteSongs));
        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());
        int k=0;
        for (int i =0;i<10;i++){
            desertIslandPlaylist.remove(k);
        }
        System.out.println(desertIslandPlaylist.size());
        System.out.println(desertIslandPlaylist);
        int SongA=desertIslandPlaylist.indexOf("Travis Scoot - Skitzo");
        int SongB=desertIslandPlaylist.indexOf("Sanah - hip hip hura!");
        String tempA=desertIslandPlaylist.get(SongA);
        desertIslandPlaylist.set(SongA,desertIslandPlaylist.get(SongB));
        desertIslandPlaylist.set(SongB,tempA);
        System.out.println(desertIslandPlaylist.get(SongA));
        System.out.println(desertIslandPlaylist.get(SongB));



    }
}

