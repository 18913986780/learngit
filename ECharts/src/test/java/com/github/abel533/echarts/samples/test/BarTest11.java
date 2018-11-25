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
import java.util.List;

import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.series.Series;
import org.junit.Test;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.util.EnhancedOption;
import sun.rmi.runtime.NewThreadAction;

/**
 * @author liuzh
 */
public class BarTest11 {

    @Test
    public void test() throws Exception {
        //地址：http://www.echartsjs.com/examples/editor.html?c=bar-y-category
        EnhancedOption option = new EnhancedOption();
        option.title().text("世界人口总量").text("考完频率(%)");
        option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
        option.grid().containLabel(true).right("4%").left("3%").bottom("3%");
        option.xAxis(new CategoryAxis().boundaryGap(new double[]{0,0.01}).type(AxisType.value));

        CategoryAxis category=new CategoryAxis();
        category.data("巴西");
        category.data("印尼");
        category.data("美国");
        category.data("印度");
        category.data("中国");
        category.data("世界人口(万11)");


        option.yAxis(category);

        Bar bar = new Bar();
        bar.data(5);
        bar.data( 15);
        bar.data(30);
        bar.data(2);
        bar.data( 8);
        bar.data( 70);
        bar.type(SeriesType.bar);
        bar.name("2012年");
        option.series(bar);

        String filePath=option.exportToHtml("bar1.html");
        System.out.println("44----------"+filePath);

        //String cmd="phantomjs.exe C:\\Users\\Administrator\\Desktop\\Java结合phantomjs后台生成图片\\Java结合phantomjs后台生成图片\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" F:\\tmp\\echarts\\bar1.png";
        String cmd="G:\\tmp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe G:\\tmp\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" G:\\tmp\\img\\bar1.jpeg";
        Process p= Runtime.getRuntime().exec(cmd);
            BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
            String line;
            while((line=bReader.readLine())!=null) {
                System.out.print(line);
            }

        option.view();
    }
}
