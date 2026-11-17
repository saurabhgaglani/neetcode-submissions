class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] i : prerequisites){
            int course = i[0];
            int prereq = i[1];
            graph.get(course).add(prereq);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int course = 0; course < numCourses; course++){
            if(!dfs(course, graph, visiting, visited)) return false;
        }

        return true;
    }

    public boolean dfs(int course, List<List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited){
        if(visiting.contains(course)) return false;
        if(visited.contains(course)) return true;
        visiting.add(course);
        for(int i : graph.get(course)){
            if(!dfs(i, graph, visiting, visited)) return false;
        }
        visiting.remove(course);
        visited.add(course);
        return true;
    }
}
