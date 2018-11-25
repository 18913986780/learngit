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

package com.github.abel533.echarts.samples.rarda;

import org.junit.Test;

import com.github.abel533.echarts.Radar;
import com.github.abel533.echarts.data.RadarData;
import com.github.abel533.echarts.series.RadarSeries;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.util.EnhancedOption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
 * 雷达图测试1
 *
 * @author liuxu
 * @date 18-7-10下午4:21
 */
public class RadarTest11 {

    @Test
    public void test()  throws Exception{

        EnhancedOption option = new EnhancedOption();

        option.title().text("各知识点得分率统计图");

        option.legend("预算分配（Allocated Budget）", "实际开销（Actual Spending）");


        //设置 Radar
        Radar radar = new Radar();
        radar.name(new Radar.Name().textStyle(new TextStyle().color("#fff").backgroundColor("#999").borderRadius(3).padding(new Integer[]{3, 5})));


        radar.indicator(new Radar.Indicator().name("销售").max(6500),
                new Radar.Indicator().name("管理").max(16000),
                new Radar.Indicator().name("信息技术").max(30000),
                new Radar.Indicator().name("客服").max(38000),
                new Radar.Indicator().name("研发").max(52000),
                new Radar.Indicator().name("市场").max(25000));
        option.radar(radar);
        //设置 Series
        RadarSeries radar1 = new RadarSeries("预算 vs 开销（Budget vs spending）");
        RadarData radarData1 = new RadarData("预算分配", new Integer[]{4300, 10000, 28000, 35000, 50000, 19000});
        radar1.data(radarData1);

        option.series(radar1);
        System.out.println(option.toString());
        String filePath=option.exportToHtml("radar1.html");
        System.out.println("44----------"+filePath);


        String cmd="G:\\tmp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe G:\\tmp\\phantomjs-2.1.1-windows\\bin\\request.js file:///"+filePath+" G:\\tmp\\img\\bar1.jpeg";
        Process p= Runtime.getRuntime().exec(cmd);
        BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
        String line;
        while((line=bReader.readLine())!=null) {
            System.out.print(line);
        }

        //option.view();
    }
}
