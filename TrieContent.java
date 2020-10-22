
public class TrieContent {   //lexiographical representation of letter
	static class TrieNode
	{
		boolean endword;
		TrieNode children[]=new TrieNode[26];
		TrieNode()
		{
			 endword=false;
			 for(int i=0;i<26;i++)
			 {
				 children[i]=null;
			 }
			
		}
	}
	static TrieNode root;
	public static void display(TrieNode root,char[] ch,int level)
	{
		if(root.endword==true)
		{
			ch[level]='\0';
			System.out.println(ch);
		}
		for(int i=0;i<26;i++)
		{
			if(root.children[i] != null)
			{
				ch[level]=(char) (i+'a');
				display(root.children[i],ch,level+1);
			}
		}
	}
	public static void insert(String keys)
	{
		
		int level;
		int index;
		int length=keys.length();
		TrieNode pcrawl=new TrieNode();
		pcrawl=root;
		for(level=0;level<length;level++)
		{
			index=keys.charAt(level)-'a';
			if(pcrawl.children[index]==null)
			{
				pcrawl.children[index]=new TrieNode();
				pcrawl=pcrawl.children[index];
				
			}
		}
		pcrawl.endword=true;
	
	}
	 
	public static void main(String [] args)
	{
		TrieContent tr=new TrieContent();
		String keys[]= {"the","a","sam","ram"};
		root=new TrieNode();
		for(int i=0;i<keys.length;i++)
		{
			insert(keys[i]);
		}
		int level=0;
		char ch[]=new char[26];
		display(root,ch,level);
	}

}
