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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.abel533.echarts.samples.pie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.util.EnhancedOption;

/**
 * 复杂的时间轴效果
 *
 * @author liuzh
 */
public class PieTest777 {

    @Test
    public void test() throws Exception{
        //地址：http://echarts.baidu.com/doc/example/pie7.html
        List list=new ArrayList();
        list.add("直接访问");
        list.add("邮件营销");
        EnhancedOption option = new EnhancedOption();
        option.title().text("等级分布统计图").x("center");//标题，居中
        option.tooltip().formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().x("left").data(list);
        option.toolbox().show(true);



        //option.exportToHtml("pie7.html");
        String filePath=option.exportToHtml("pie8.html");


        String cmd="G:\\tmp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe G:\\tmp\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" G:\\tmp\\img\\bar1.jpeg";
        Process p= Runtime.getRuntime().exec(cmd);
        BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
        String line;
        while((line=bReader.readLine())!=null) {
            System.out.print(line);
        }
//System.out.println("0--------"+line);


        option.view();
    }

    /**
     * 获取饼图数据
     *
     *
     * @return
     */
    public Pie getPie() {
        return new Pie().name("浏览器（数据纯属虚构）").data(
                new PieData("A", 50),
                new PieData("B", 10),
                new PieData("C", 20),
                new PieData("D", 10),
                new PieData("E", 30));
    }
}
