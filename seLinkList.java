public class seLinkList{
		public seLinkList next;
		public int a;
		public int b;
		public int c;
		public int index;
		public seLinkList prev;
		/*public seLinkList(){//when empty;
			this.next = null;
			this.a = 0;
			this.b = 0;
			this.c = 0;
			this.index = 0;
		}*/
		public seLinkList(seLinkList next, int a, int b, int c, int index, seLinkList prev){
			this.next =next;
			this.a = a;
			this.b = b;
			this.c = c;
			this.index = index;
			this.prev = prev;
		}
	}