package com.edu.edusystem;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//隐私政策
public class Privacy extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

        Toolbar toolbar=findViewById(R.id.toolbar);//绑定toolbar
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back);
//        toolbar.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {//sdk21以上的沉浸式方法
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//？
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//状态栏文字颜色
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(0);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView privacy_tv=findViewById(R.id.privacy_tv);
        String privacy="<font color=\"#000000\"><big><big>用户隐私政策</big></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;本平台包括但不限于通过有线或移动设备访问本平台的个人及企业的个人信息及隐私。鉴于您在使用我们的服务时,我们可能会收集和使用您的相关信息,为向您阐明用户信息收集、使用、共享、管理及保护的规则,特制定本《隐私政策》( 以下或称\"本政策”)。并特别提醒您:<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;本政策不适用于其他第三方向您提供的服务。例如入驻的.卖家依托平台向您提供服务时,您向卖家提供的个人信息不适用本政策。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#D50000\">本政策与用户所使用的本平台服务信息相关, 在使用APP各项产品或服务前,请您务必仔细阅读并透彻理解本政策,在确认充分理解并同意后使用相关产品或服务。- 旦您开始使用,即表示您已充分理解并同意本政策。</font><br>\n" +
                "\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;如对本政策或相关事宜有任何问题,请通过客服热线:与本平台联系。<br>\n" +
                "<font color=\"#000000\"><big><b>一、用户信息的收集及使用</b></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;本平台提供服务时,可能会收集、储存和使用下列与用户有关的信息。如果用户不提供相关信息,可能无法注册成为本平台的会员或无法享受本平台提供的某些服务,或者无法达到相关服务拟达到的效果。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>1、用户提供的信息</b></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您使用手机号码注册成为会员时,您需要提供手机号码,并设置会员密码。如果您仅需使用浏览基本服务,您不需要注册成为我们的会员及提供上述信息。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您使用我们服务所.上传的信息,如昵称，上传的头像。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>2、平台获取的用户信息</b></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;为向您提供更契合您需求的页面展示和搜索结果、了解产品适配性、识别账号异常状态,我们会收集关于您使用的服务以及使用方式的信，息并将这些信息进行关联,这些信息包括:<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;设备信息:我们会根据您在软件安装,接收并记录您所使用的设备相关信息, 如设备型号、设备设置、唯一设备标识符等软硬件特征信息、设备所在位置相关信息,如IP地址。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;日志信息:当您使用我们的网站或客户端提供的产品或服务时,我们会自动收集您对我们服务的详细使用情况,作为有关网络日志保存。如您的搜索信息、IP地址、访问日期和时间及您访问的网页记录等。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>3、其他第三方获取得与用户信息</b></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;其他方使用本平台的服务时所提供有关用户的共享信息。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;我们将信息用于本政策未载明的其他用途, 或者将基于特定目的收集而来的信息用于其他目的时, 会事先征求您的同意。<br>\n" +
                "<font color=\"#000000\"><big><b>二、用户信息的共享、转让和公开披露</b></big></font><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;除以下情况外,我们不会将您的个人信息提供给本公司以外的任何个人、公司或组织共享、转让给和公开披露:<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(1)依据本政策或事先已获得您明确的同意或授权;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(2 )根据适用的法律、法规、法律程序的要求、行政或司法的强制性要求所必须时<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(3)在法律、法规允许的范围内,为维护APP及关联方或合作伙伴、您或其他APP用户 或社会公共利益、财产或安全免遭损害时;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(4)据与您签署的相关协议或其他法律文件的约定;<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#D50000\">您理解并同意,根据法律规定,共享、转让经去标识化处理的个人信息,且确保数据接收方无法复原并重新识别个人/企业信息主体的,不属于个人信息的对外共享、转让及公开披露行为,对此类数据的保存及处理将无需另行向您通知并征得您的同意。</font><br>\n" +
                "<font color=\"#000000\"><big><b>三、用户个人信息的保护</font></big><b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;1、 我们已采取符合法律规定、合理可行的安全防护措施和制度保护您个人信息的安全, 防止您的个人信息遭到未经授权访问、公开披露、使用、修改、损坏或丢失。例如,在某些服务中,本平台将利用加密技术来保护用户提供的个人信息。但请您理解,由于技术的限制以及可能存在的各种恶意手段,在互联网行业,即便竭尽所能加强安全措施,也不可能始终保证信息百分之百的安全。用户需要了解,用户接入本平台的服务所用的系统和通讯网络,有可能因本平台可控范围外的因素而出现问题。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;2、我们会采取合理可行的措施以避免收集无关的个人信息。我们只会在达成本政策所述目的所需期限内保留您的个人信息，除非需要延长保留期或应法律法规的允许或要求。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;3、在不幸发生个人信息安全事件后,我们将按照法律法规的要求向您告知:安全事件的基本情况和可能的影响、我们已采取或将要采取的处置措施、您可自主防范和降低风险的建议、对您的补救措施等。事件相关情况我们将以信函、电话、推送通知等方式告知您,难以逐一告知个人信息主体时,我们会采取合理、有效的方式发布公告。同时,我们还将按照监管部门要求上报个人信息安全事件的处置情况。<br>\n" +
                "<font color=\"#000000\"><big><b>四、用户个人信息的保存、访问和管理</font></big><b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>1、用户个人信息的保存</b></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您的个人信息将全部被存储于中华人民共和国境内,但以下情形除外:<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(1)法律法规另有明确规定;<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;(2)获得您的明确授权;<br>\n" +
                "<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;针对以上情形,我们会依据本政策及相关法律法规对您的个人信息提供保护。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>2、用户个人信息的访问</b></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您有权通过以下方式访问您的个人信息,但法律法规另有规定,或本政策另有约定除外。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;账户信息:若您希望访问或编辑您的账户中的个人基本资料等信息,您可登录账号通过“账号管理/公司管理”执行此类操作。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;若您无法通过上述路径访问该等信息,您可通过客服与我们联系。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>3、用户个人信息的更正、补充</b></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;当您发现您的个人信息有误或需要补充时,您可通过“用户个人信息的访问”中列明的方式提出更正或补充申请。<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#000000\"><big><b>4、用户个人信息的删除</b></big></font><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您可通过“用户个人信息的访问”中列明的方式删除您的部分个人信息。<br>\n" +
                "在以下情形中,您可向我们提出删除个人信息的请求:<br>\n" +
                "(1)我们处理个人信息的行为违反法律法规;<br>\n" +
                "<br>\n" +
                "(2)我们收集、使用您的个人信息, 却未征得您的明确<br>\n" +
                "<br>\n" +
                "(3)我们处理个人信 息的行为严重违反了与您的约定;<br>\n" +
                "<br>\n" +
                "(4)您不再使 用我们的产品或服务。<br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;为响应您的上述请求为保障安全,您可能需要提供书面请求,或以其他方式证明您的身份。我们可能会先要求您验证自己的身份,然后再处理您的请求。对于您合理的请求我们原则上不收取费用。对于那些无端重复、给他人合法权益带来风险或者非常不切实际的请求,我们可能会予以拒绝。<br>\n" +
                "<font color=\"#000000\"><big><b>六、Cookie 及类似技术的使用</font></big><b><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;当用户访问设有Cookies装置的本平台时,本平台服务器会自动发送Cookies至用户浏览器中,同时储存进用户的电脑硬盘内,此Cookies便负责记录日后用户访问本平台时的种种操作、浏览消费习惯、信用记录等。运用Cookies技术 ,本APP能够为您提供更加周到的个性化服务。本APP将运用Cookies技术向用户提供其感兴趣的信息资料或为其储存密码。<br>\n" +
                "<font color=\"#000000\"><big><b>七、未成年人的特别注意事项</font></big><b><br>\n" +
                "<br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;如果您未满18周岁,您无权使用本平台产品或服务, 此,请您不要在本平台从事交易行为。<br>\n" +
                "<font color=\"#000000\"><big><b>八、隐私政策更新</font></big><b><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您理解并同意,本平台有权根据业务发展的需要单方修订本政策,并以修订后的版本完全替代修订前的版本。请您及时关注和了解本政策的修订情况,若您不同意修订后版本,您应立即停止使用平台服务,否则即视同您同意并完全接受修订后的版本<br>\n" +
                "<font color=\"#000000\"><big><b>九、联系方式</font></big><b><br>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;您可以通过以下方式与我们联系,我们将在15天内回复您的请求:<br>\n" +
                "QQ:365210<br>\n" ;
        privacy_tv.setText(Html.fromHtml(privacy));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
