import java.util.ArrayList;
import java.util.Scanner;




public class Solution {
	static int[][] tree;
	static ArrayList<Integer> parentList;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수
			tree = new int[V+1][2];
			parentList = new ArrayList<Integer>();
			int first = sc.nextInt();
			int second = sc.nextInt();
			for(int i=1; i<=E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				if(tree[parent][0]==0) {
					tree[parent][0] = child;
				} else {
					tree[parent][1] = child;
				}
			}
			findParent(first);
			findParent(second);
			int[] parentCount = new int[V+1];
			for(int i=0; i<parentList.size(); i++) {
				parentCount[parentList.get(i)]++;
			}
			for(int i=parentList.size()-1; i>=0; i--) {
				if(parentCount[parentList.get(i)]<2) parentList.remove(i);
			}
			
			int nearSameParent = parentList.get(0);
			int subTreeCount = subTreeCount(nearSameParent);
			System.out.println("#" + test_case + " " + nearSameParent + " " + subTreeCount);
		}
	}
	
	public static void findParent(int n) {
		for(int i=1; i<tree.length; i++) {
			if(tree[i][0]==n || tree[i][1]==n) {
				parentList.add(i);
				findParent(i);
			}
		}
	}

	public static int subTreeCount(int start) {
		int left = tree[start][0];
		int right = tree[start][1];
		if(start==0) return 0;
		if(left==0 && right==0) return 1;
		return 1 + subTreeCount(left) + subTreeCount(right);
	}
}