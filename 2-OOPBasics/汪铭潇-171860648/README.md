﻿设计两个类：Kid 和 GourdDoll

Kid用来表示单个葫芦娃个体（包括他们的属性：姓名name，排名权值val，颜色color）
其中颜色color设计了一个public 的枚举类型skinColor


GourdDoll用来作为public类，采用组合的方法，在其中实例化七个Kid的对象作为kids数组来进行相应操作。
其中定义了一个调用Random类随机打乱数组序列outOrder方法

在main（）中实例化了一个GourdDoll的对象，调用其方法完成任务要求