#SkinManager  
  一个不需要重启界面，就能切换日夜间模式的库
  
##描述  
一般在程序中需要做日夜间模式  
切换逻辑所处的页面和activity栈底的页面是做不到不重启切换的.  
这些特殊页面就可以使用本库来完成，实现不重启切换界面
  
###实现思路
利用在编写xml布局的时候，通过继承常用View。  
等到接收到切换模式消息时，  
由View自己更换xml布局中定义好的相应模式下的颜色、背景等.
  
<hr width='500px' size='1' />
  
####1.0版本:
完成了常用View  
三大布局:线性,相对,帧  
ImageVIew/TextView/CheckBox/EditText/View  
