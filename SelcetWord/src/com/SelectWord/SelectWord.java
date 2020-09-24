package com.SelectWord;
/*
 * 编写一个能够从“words.txt”中读取单词，并且，
 * 将所有单词中存在最多重复字母对的那些单词写入到“newwords.txt”中。
 * @author 计算机1802 李杨
 * Version 1.0
 * date 2020-04-21
 */
import java.io.*;
public class SelectWord {
	/**
	 *     
	 * @param  src 计算每次读取到的单词中重复字母对的个数
	 * @return 返回数目count
	 */
		public static int countDiffer(String src) {
			int count = 0;
			if (src.isEmpty()) count = 0;
			else {
			for (int i = 0; i < src.length()-1; i++) {
	  	    char c = src.charAt(i);
	  	    if(c==' ' )break;
	  	    	if(c == src.charAt(i+1))
	  	    		count++;
	  	  	    		}
		    	}
			return count;
		}
		
	public static void main(String args[]) {
		 File readfile =new File("words.txt"); 
		 File writefile = new File("Newwords.txt");
	try {
			//定义BufferedReader 对象words 方便程序按行读取words.txt中的单词			
			FileReader word = new FileReader(readfile);
			BufferedReader words = new BufferedReader(word);//通过words可以进行按行读取
			/*
			 *计算words文件中最每个单词重复字母对分最大数目 
			 *方便后续对单词的筛选
			 */
			String s = new String();			
			int M_count=0;
			while((s = words.readLine()) != null) {
				int count = countDiffer(s);
				if(count > M_count)
				M_count=count;	//一遍
			}
			System.out.println("最对字母对的个数："+M_count);
			
			//定义BufferedWriter out对象
			//方便新单词按行写入Newwords.txt文件			
			FileWriter newword = new FileWriter(writefile);
			BufferedWriter out = new BufferedWriter( newword);//通过out按行写入文件中

			//当再次调用readLine()需要重新定义变量BufferReader 所指向的源文件
			//不然再进入循环时会出现：找不到Source file错误
			word = new FileReader(readfile);
			words = new BufferedReader(word);
			/*
			 * 旧单词通过M_count筛选并写入Newwords.txt中	
			 */			
			String str=new String();//为了便于理解再定义一个字符串，用String s亦可
			while((str = words.readLine())!=null){//运行到这里就找不到Source file
				if(countDiffer(str)==M_count) {//两遍
					//System.out.println(str);
				out.write( str );
				out.newLine();
				}
			 }
			out.close();
			newword.close();
			/*
			 * 将Newwords.txt文件中的单词
			 */
			word = new FileReader(writefile);//读取Newwords.txt中的单词 
			words = new BufferedReader(word);
			while ((s = words.readLine())!=null) {
				System.out.println(s);//在控制台打印出所有 
				}
			word.close();
			words.close();			
			}
		catch(IOException e){
			System.out.println(e);			
		}
	}
}

