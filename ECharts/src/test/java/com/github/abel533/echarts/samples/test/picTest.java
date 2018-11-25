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

package com.github.abel533.echarts.samples.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Pie;
import org.junit.Test;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.util.EnhancedOption;

/**
 * @author liuzh
 */
public class picTest {

    @Test
    public void test() throws Exception {
        //地址：http://www.echartsjs.com/examples/editor.html?c=bar-y-category
        EnhancedOption option = new EnhancedOption();
        option.tooltip().trigger(Trigger.item).formatter( "{a} <br/>{b}: {c} ({d}%)");
        option.title().text("等级分布统计图").left("center");
        List list=new ArrayList();
        list.add("A:90-100分");
        list.add("B:75-89分");
        list.add("C:60-74分");
        list.add("D:0-59分");
        option.legend().orient(Orient.vertical).x("left").data(list);

        Pie pie = new Pie();//Pie继承了Series
        pie.name("访问来源");
        pie.type(SeriesType.pie);
        pie.radius(new Object[]{"50%","70%"});
        //pie.radius("50%","70%");
        pie.avoidLabelOverlap(false);
        pie.label().normal().formatter("{b}:{c}: ({d}%)").textStyle().fontWeight("normal").fontSize(15);
        pie.data(new PieData("90-100分", 15),
                new PieData("75-89分", 20),
                new PieData("60-74分", 10),
                new PieData("0-59分+", 32));


        option.series(pie);


        String filePath=option.exportToHtml("bar12.html");
        System.out.println("444----------"+filePath);

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
