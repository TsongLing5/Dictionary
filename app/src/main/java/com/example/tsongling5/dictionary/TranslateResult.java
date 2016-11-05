package com.example.tsongling5.dictionary;

/**
 * Created by TsongLing5 on 2016/10/31.
 */
public class TranslateResult {
    private String word;

    private String pronunciationAm,pronunciationEn;
    private String pronunciationAmVocal,pronunciationEnVocal;
//    private ArrayList<ExplainItem> meansList;
    private String[] property=new String[4];
    private String[] defination=new String[4];;
    public TranslateResult(){

    }

    void setWord(String word){
        this.word=word;
    }

    public String getWord(){
        return this.word;
    }

    void setPronunciation(String pronunciationAm,String pronunciationEn){
        this.pronunciationAm=pronunciationAm;
        this.pronunciationEn=pronunciationEn;

    }
    public String getPronunciationAm(){
        return this.pronunciationAm;
    }

    public String getPronunciationEn(){
        return this.pronunciationEn;
    }

    void setPronunciationVocal(String pronunciationAmVocal,String pronunciationEnVocal){
        this.pronunciationAmVocal=pronunciationAmVocal;
        this.pronunciationEnVocal=pronunciationEnVocal;

    }
    void setMeans(int i,String property,String defination){


        this.property[i]=property;
        this.defination[i]=defination;
//        means[i][j]=s;
//        ExplainItem e=new ExplainItem(i,means);
//        this.meansList.add(e);
    }
    public String getMeans(){
        return null;
    }
}
