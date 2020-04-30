##  需求描述

将应用内的数据导出为excel表格。

##  实现

###  添加依赖包
fork自  https://github.com/DmrfCoder/AndroidExcelDemo.git
在此基础上加入了反射和泛型，不再用创建的时候指定列名等，直接放入对象数列即可


在app的build.gradle里面添加依赖包:

```java
implementation group: 'net.sourceforge.jexcelapi', name: 'jxl', version: '2.6.12'
```

  String filePath = "D:\\androidProject\\demo.xls";

        //创建文件部分     bean可以自己定义  如有需要可以中文命名，这样文件就会显示中文列明
        List<String> titles = ReflectDemoUtils.getFiledNames(DemoBean.class);


        ExcelUtil.initExcel(filePath, "demo", titles);



        //数据生成部分 写自己的代码
        List<DemoBean> demoBeanList = new ArrayList<>();
        inner:for (int i1 = 1; i1 <= 8; i1++) {

            double temp = 0;
            out:for (int i = 0; i < 31; i++) {

                double result = getResult(i, i1);
                if (result <= 1) continue out;
//                System.out.println("倍率:" + i + "胜场:" + i1 + "收益倍数:" + result);
                temp = result > temp ? result : temp;

//                if (result<300&&result>100)
                demoBeanList.add(new DemoBean(i, i1, result));
            }
        }

        //写入数据部分
        ExcelUtil.writeObjListToExcel(demoBeanList, filePath);

最终生成的excel效果如下：

![image-20190216174313758](https://ws3.sinaimg.cn/large/006tKfTcly1g08empfrhrj30u01o0tby.jpg)

注意一定要处理权限申请的相关工作。