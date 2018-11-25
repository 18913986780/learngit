/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.abel533.echarts.samples.bar;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.util.EnhancedOption;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzh
 */
public class BarTest1 {



    @Test
    public void test() throws Exception {
        //地址：http://echarts.baidu.com/doc/example/bar1.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.axis);
        option.legend("蒸发量", "降水量");
        //右上角的下载，刷新等按钮。
        //option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        option.yAxis(new ValueAxis());

        Bar bar = new Bar("蒸发量");
        bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
        bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
        bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));

        Bar bar2 = new Bar("降水量");
        List<Double> list = Arrays.asList(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
        bar2.data(list);
        bar2.markPoint().data(new PointData("年最高", 182.2).xAxis(7).yAxis(183).symbolSize(18), new PointData("年最低", 2.3).xAxis(11).yAxis(3));
        bar2.markLine().data(new PointData().type(MarkType.average).name("平均值"));

        option.series(bar, bar2);
        String filePath=option.exportToHtml("bar1.html");
        System.out.println("44----------"+filePath);


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

        Process p;
            p = Runtime.getRuntime().exec(cmd);
            //判断文件是否存在
            File f=new File("F:\\tmp\\echarts\\bar1.png");
            int i=3;
            //如果不存在则再次生成，生成3次，直接退出，生成失败
//            if( !f.exists()){
//                while(i>0){
//                    i--;
//                    Runtime.getRuntime().exec(cmd);
//                }
//
//                    //写入日志，生成失败
//                    System.out.println("生成失败了");
//
//            }
            //这个是控制台的输出，可以直接到控制台
            BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
            String line;
            while((line=bReader.readLine())!=null) {
                //这里写入日志，方便以后日志追踪，具体的日志，为什么会生成失败，这里会有输出
                System.out.print(line);
            }


            //生成图片之后，删除html和png图片，这个代码要是插入doc文档才能做
            /*if(line.contains("success")){
                //删除html
                //删除图片
            }*/



        //以上是phantomjs生成图片的代码，end

    }
}
