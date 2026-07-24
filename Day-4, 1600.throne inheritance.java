class ThroneInheritance {
    Map<String, List<String>> children = new HashMap<>();
    Map<String, Integer> deathTime = new HashMap<>();
    String king;
    
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        children.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parent, String child) {
        children.putIfAbsent(parent, new ArrayList<>());
        children.get(parent).add(child);
        children.putIfAbsent(child, new ArrayList<>());
    }
    
    public void death(String name) {
        deathTime.put(name, 1);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }
    
    private void dfs(String person, List<String> result) {
        if (!deathTime.containsKey(person)) {
            result.add(person);
        }
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}
