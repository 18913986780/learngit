package test;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.series.Bar;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class EchartsTest {
    public static void main(String agrs[]) {
        System.out.println("111---");
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test() throws Exception {
        //地址：http://echarts.baidu.com/doc/example/bar1.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("各分数段人数统计图");
        option.tooltip().trigger(Trigger.axis);
        //option.legend("蒸发量", "降水量");
        //右上角的下载，刷新等按钮。
        //option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.xAxis(new CategoryAxis().data("0-9分", "10-19分", "20-29分", "30-39分", "40-49分", "50-59分", "60-69分", "70-79分", "80-89分", "90-100分"));
        option.yAxis(new ValueAxis());

        Bar bar = new Bar();
        bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0);
        //bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
        //bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));

        option.series(bar);
        String filePath=option.exportToHtml("bar1.html");
        System.out.println("5555----------"+filePath);


        //以下是phantomjs生成图片的代码，begin
        StringBuffer sb=new StringBuffer();
        sb.append("phantomjs.exe ").append("C:").append(File.separator).append("Users")
                .append(File.separator)
                .append("Administrator")
                .append(File.separator)
                .append("Desktop")
                .append(File.separator)
                .append("Java结合phantomjs后台生成图片")
                .append(File.separator)
                .append("Java结合phantomjs后台生成图片")
                .append(File.separator)
                .append("phantomjs-2.1.1-windows")
                .append(File.separator)
                .append("bin")
                .append(File.separator)
                .append("request.js file:///")
                .append(filePath)
                .append(" ")
                .append("F:")
                .append(File.separator)
                .append("tmp")
                .append(File.separator)
                .append("echarts")
                .append(File.separator)
                .append("bar1.png");

        //String cmd="phantomjs.exe C:\\Users\\Administrator\\Desktop\\Java结合phantomjs后台生成图片\\Java结合phantomjs后台生成图片\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" F:\\tmp\\echarts\\bar1.png";
        String cmd="G:\\tmp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe G:\\tmp\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" G:\\tmp\\img\\bar1.jpeg";
        Process p= Runtime.getRuntime().exec(cmd);
        System.out.println("777----------"+p);
        //这个是控制台的输出，可以直接到控制台
        BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
        String line;
        while((line=bReader.readLine())!=null) {
            System.out.println("999----------"+line);
            System.out.print(line);
        }
    }


}
