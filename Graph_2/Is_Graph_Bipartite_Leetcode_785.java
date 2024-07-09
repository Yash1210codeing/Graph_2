package Graph_2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class Is_Graph_Bipartite_Leetcode_785 {
class Solution{
	public boolean isBipartite(int[][]graph) {
		HashMap<Integer,Integer>visited=new HashMap<>();
		Queue<BipartitePair>q=new LinkedList<>();
		for(int src=0;src<graph.length;src++) {
		if(visited.containsKey(src)) {
			continue;
		}
		//count++;
		q.add(new BipartitePair(src,0));
		while(!q.isEmpty()) {
			//int rv=q.poll();
			BipartitePair rv=q.poll();
			if(visited.containsKey(rv.vtx)) {
				if(visited.get(rv.vtx)!=rv.distance) {
					return false;
				}else {
					continue;
				}				
			}
			visited.put(rv.vtx,rv.distance);
			for(int nbrs:graph[rv.vtx]) {
				if(!visited.containsKey(nbrs)) {
					BipartitePair np=new BipartitePair(nbrs,rv.distance+1);
					q.add(np);
				}
			}
		}
		}
		return true;
	}
	class BipartitePair{
		int vtx;
		int distance;
		public BipartitePair(int vtx,int distance) {
			this.vtx=vtx;
			this.distance=distance;
		}
	}
}
}