package com.makao.util;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

public class TokenUtil {

    private long stime;  
    private long etime;  
    private Analyzer analyzer;  
    @Before  
    public void s(){  
        stime = System.currentTimeMillis();  
    }  
    @After  
    public void e(){  
        etime = System.currentTimeMillis();  
        System.out.println("使用" + analyzer.getClass().getName() + "分词， 耗时" + (etime - stime) + "ms");  
    }  
      
    @Test  
    public void test() throws Exception {  
        //analyzer = new SimpleAnalyzer(Version.LUCENE_35);  
        //analyzer = new StandardAnalyzer(Version.LUCENE_35);  
        analyzer = new MMSegAnalyzer();  
        
        analyze(analyzer, "笑星潘长江当上“男媒婆”了，但这回可不是演小品——由他自编自导自演的都市喜剧《男媒婆》将于1月13日在北" +  
            "京卫视首播。剧中，潘长江变身成为能说会道、古道热肠的“新时代男媒婆”丁二春，与“台湾第一酒窝美女2”张庭上演了一出“屌丝逆袭”" +  
            "的浪漫追爱记。李明启、李文启、冯远征、任程伟、马丽、徐等明星也齐齐上阵制造“笑料”《男媒婆》围绕着丁二春和他所开" +  
            "办的“全成热恋”婚介所展开。人到中年的丁二春眼看来势汹涌的“婚恋大潮”商机不断，想凭借一张巧嘴开创事业和人生" +  
            "“第二春”。婚介所开张大吉，顾客盈门，提出的要求却也千奇百怪，拜金女、宅男、小老板粉墨登场，展开了一系列令人捧腹" +  
            "大笑又不失温情的精彩故事。剧中的一大看点是美女搭配“丑男”的搭配，张庭与潘长江成了一对欢喜冤家。张庭表示，剧中两人“" +  
            "身高有差距、年龄有距离，相貌不对等”。而潘长江谈到这种主角设定时认为：“张庭以往的角色都特别独立、可爱，而‘大女人’和‘" +  
            "小男人’正是我俩这对情侣的设定，所以张庭是非常合适的人选。”此外，该剧也是潘长江继《能人冯天贵》、《清凌凌的水蓝莹莹的天》" +  
            "第一、第二部之后第四次自导自演的喜剧作品。潘长江表示，全剧通过“媒婆”这个特殊职业的视角，展示着当代社会种种婚恋价值观，涵盖了" +  
            "黄昏恋、拜金女、凤凰男等诸多引发热议的时代话题。(记者 尹春芳)免责声明：本文仅代表作者个人观点，与环球网无关。其原创性以及文中" +  
            "陈述文字和内容未经本站证实，对本文以及其中全部或者部分内容、文字的真实性、完整性、及时性本站不作任何保证或承诺，请读者仅作参考，" +  
            "并请自行核实相关内容。");  
    }  
    private void analyze(Analyzer analyzer, String text) throws Exception {  
        TokenStream tokens = analyzer.tokenStream("content", new StringReader(text));
        OffsetAttribute offsetAttr = tokens.getAttribute(OffsetAttribute.class);  
        CharTermAttribute charTermAttr = tokens.getAttribute(CharTermAttribute.class);  
        while (tokens.incrementToken()) {  
            char[] charBuf = charTermAttr.buffer();  
            String term = new String(charBuf, 0, offsetAttr.endOffset() - offsetAttr.startOffset());  
            System.out.println(term + ", " + offsetAttr.startOffset() + ", " + offsetAttr.endOffset());  
        }  
        tokens.close();  
        // while (ts.incrementToken()) {//过时  
        // TermAttribute ta = ts.getAttribute(TermAttribute.class);  
        // System.out.println(ta.term());  
        // }  
    }  

}
