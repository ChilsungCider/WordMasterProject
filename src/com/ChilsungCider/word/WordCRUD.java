package com.ChilsungCider.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner s;

    final String filename = "Lee.txt";

    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public Object add() {
        // TODO Auto-generated method stub
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }


    public void addWord() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.\n");
    }

    @Override
    public int update(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Object obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void selectOne(int id) {
        // TODO Auto-generated method stub

    }
    public void listAll() {
        System.out.println("---------------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("---------------------------------------");
    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idList = new ArrayList<>();
        int k = 0;
        System.out.println("\n---------------------------------------");
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if (!word.contains(keyword)) continue;
            System.out.print((k + 1) + " ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            k++;
        }
        System.out.println("---------------------------------------\n");
        return idList;
    }

    public void listAll(int level) {
        int k = 0;
        System.out.println("\n---------------------------------------");
        for(int i = 0; i < list.size(); i++) {
            int iLevel = list.get(i).getLevel();
            if (iLevel != level) continue;
            System.out.print((k + 1) + " ");
            System.out.println(list.get(i).toString());
            k++;
        }
        System.out.println("---------------------------------------\n");
    }

    public void searchWord() {
        System.out.print("==> 원하는 단어는? ");
        String keyword = s.next();
        listAll(keyword);
    }

    public void updateWord() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("==> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("==> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void systemOut(){
        System.out.println("\n프로그램이 종료되었습니다.");
    }

}
