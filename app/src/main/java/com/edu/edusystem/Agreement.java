package com.edu.edusystem;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//用户协议
public class Agreement extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agreement);
        TextView agreement_tv=findViewById(R.id.agreement_tv);
        String agree="<font color=\"#000000\"><big><big>用户服务协议</big></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;请您务必仔细阅读本服务协议,特别是免除或者限制责任的条款,注册登录或者实际使用本APP ,即视为您已阅读并同意上述协议的约束。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;本公司有权随时对本协议进行修改,且不承担通知义务,您若不同意应停止使用,若继续使用,则视为您愿意遵守更新后的协议。<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第一条、服务内容</big></font></b><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;1.1APP的具体内容包任务发布,帖子交流,足球交友等内容。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;1.2与相关网络服务有关的设备(如个人电脑、手机、及其他与接入互联网或移动网有关的装置)及所需的费用(如为接入互联网而支付的网络费用、手机流量费等)均应由您自行负担。<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第二条、用户账号管理</big></font></b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2.1您可以通过注册成为APP的正式用户。注册时,应本着诚信提供注册资料,保证所提供的注册资料真实、准确、合法有效,如有变动的,应及时更新。如果您提供的注册资料不合法有效、不真实、不准确、不详尽的,您需承担因此引起的相应责任及后果,且保留终止您使用APP各项服务的权利。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2.2保护用户信息是我司的一项原则,注册资料涉及真实姓名/名称、联系方式、电子邮箱等隐私信息的,除法律另有规定或者司法程.序所需外,我司将予以严格保密。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2.3您注册的账号所有权归属于我司,您仅有使用权。未经平台同意,您不得转借、转让、赠与他人,否则平台有权收回该账号,并.且您应承担前述行为产生的全部法律责任。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2.4注册成功后,将产生密码等账户信息,您可以根据平台提示修改您的密码。并谨慎合理的保存、使用账户及其密码。您若发现任何非法使用用户账号或存在安全漏洞的情况,请立即通知我司。否则,由于用户自身的疏忽而导致账号信息泄露及相关损失,由您自行承担。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2.5您理解并同意,平台可通过邮件、短信、电话等形式,向您发送促销活动、产品更新等告知信息。<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第三条、使用规则</big></font></b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;3.1您应当遵守国家有关法律法规,不得在APP平台中发表、转发或者传播含有下列内容的信息:<br>\n" +
                "<br>\n" +
                "<b>&nbsp;&nbsp;&nbsp;&nbsp;(1 )反对宪法所确定的基本原则的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(2)危害国家安全、泄露国家秘密、颠覆国家政权、破坏国家统--的<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(3)损害国家荣誉和利益的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(4)煽动民族仇恨、民族歧视,破坏民族团结的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(5)破坏国家宗教政策,宣扬邪教和封建迷信的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;6)散布谣言,扰乱社会秩序,破坏社会稳定的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(7)散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(8)侮辱或者诽谤他人,侵害他人合法权益的;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(9)含有法律、行政法规禁止的其他内容的。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;3.2不得利用APP从事洗钱、窃取商业秘密、窃取个人信息等违法犯罪活动;</b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;3.3不得干扰软件的正常运转,不得侵入我司及国家计算机信息<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第四条、违约处理</big></font></b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;4.1如果发现您违反本协议约定的,我司有权不经通知随时对相关内容进行删除、屏蔽,并视行为情节对违规帐号处以包括但不限于警告、限制或禁止使用部分或全部功能、帐号封禁直至注销的处罚，并公告处理结果。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;4.2您理解并同意,因您违反本协议规定,导致或产生第三方主张的任何索赔、要求或损失,您应当独立承担责任;我司因此遭受损失的,您也应当一并赔偿。<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第五条、知识产权声明</big></font></b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;APP为我司自主研发的产品,与此相关的设计、版权等知识产权归属于我司,用户不得抄袭APP的设计、擅自对外传播APP提供的信息内容,进行反向工程或者从事其他侵犯APP知识产权的行为, AP将保留追究相关侵权人的法律责任的权利。<br>\n" +
                "<br>\n" +
                "<b><font color=\"#000000\"><big>第六条、责任限制</big></font></b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;6.1APP提供的的任何信息、表述意见并不构成对任何论点的赞同,同时,任何人不应单独依据APP发布的信息而取代自身独立的判断,应自主做出决策并承担风险。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;6.2我司有权于任何时间暂时或永久修改或终止本服务(或其任何部分) ,而无论其通知与否,对用户和任何第三人均无需承担任何责任。<br>\n" +
                "<br>\n" +
                "<font color=\"#000000\"><big><b>第七条、附则</b></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;7.1本协议的订立、执行和解释及争议的解决均应适用中华人民共和国大陆地区适用之有效法律(但不包括其冲突法规则)。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;7.2如就本协议内容或其执行发生任何争议,双方应尽力友好协商解决;协商不成时,任何一方均可向我司所在地人民法院提起诉讼解决。<br>\n";
        agreement_tv.setText(Html.fromHtml(agree));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
