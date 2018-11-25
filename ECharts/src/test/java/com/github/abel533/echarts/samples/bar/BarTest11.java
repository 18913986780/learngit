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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.util.EnhancedOption;

/**
 * @author liuzh
 */
public class BarTest11 {

    @Test
    public void test() throws Exception {
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
        System.out.println("44----------"+filePath);

        //String cmd="phantomjs.exe C:\\Users\\Administrator\\Desktop\\Java结合phantomjs后台生成图片\\Java结合phantomjs后台生成图片\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" F:\\tmp\\echarts\\bar1.png";
        String cmd="H:\\GitWorkSpace\\tmp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe H:\\GitWorkSpacetmp\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" H:\\tmp\\img\\bar1.jpeg";
        Process p= Runtime.getRuntime().exec(cmd);
            BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
            String line;
            while((line=bReader.readLine())!=null) {
                System.out.print(line);
            }

        option.view();
    }
}
