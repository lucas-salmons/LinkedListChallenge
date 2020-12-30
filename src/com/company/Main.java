package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	// write your code here
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer",4.6);
        album.addSong("Love dont mean a thing",4.22);
        album.addSong("Holy man",3.13);
        album.addSong("Hold on",5.6);
        album.addSong("Lady double dealer",2.56);
        album.addSong("You cant do it right",6.23);
        album.addSong("High ball shooter",5.01);
        album.addSong("The gypsy",4.2);
        album.addSong("Soldier of fortune",3.13);
        albums.add(album);

        album = new Album("For those about to rock","AC/DC");
        album.addSong("For those about to rock",5.44);
        album.addSong("I put the finger on you",3.25);
        album.addSong("Lets go",3.45);
        album.addSong("Inject the venom",3.33);
        album.addSong("Snowballed",6.47);
        album.addSong("Evil walks",3.45);
        album.addSong("C.O.D",5.25);
        album.addSong("Breaking the rules",5.32);
        album.addSong("Night of the long Knives",5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();

        albums.get(0).addToPlayList("You cant do it right",playList);
        albums.get(0).addToPlayList("Holy man",playList);
        albums.get(0).addToPlayList("Speed king",playList);//fail
        albums.get(0).addToPlayList(9,playList);
        albums.get(1).addToPlayList(8,playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(22,playList);//fail

        play(playList);


    }
    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing "+ listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit =true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }else{
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else{
                        System.out.println("Start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying "+ listIterator.previous());
                            forward = false;
                        } else{
                            System.out.println("At start of playlist");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying "+listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We have reached end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println(" 0 - quit\n 1 - next\n 2 - previous\n 3 - replay\n 4 - Show playlist\n 5 - menu\n 6 - remove track\n");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("--------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------------");
    }
}
