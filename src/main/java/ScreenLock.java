public class ScreenLock {

    public int calculateCombinations(char startChar, int patternLength) {
        Graph graph = new Graph();

        for (char c = 'A'; c <= 'I'; c++) {
            graph.addVertex(c);
        }

        graph.addEdge('A', 'B', false);
        graph.addEdge('A', 'D', false);
        graph.addEdge('A', 'E', false);
        graph.addEdge('A', 'H', false);
        graph.addEdge('A', 'F', false);
        graph.addEdge('A', 'X', false);
        graph.addEdge('A', 'X', false);
        graph.addEdge('A', 'X', false);
        graph.addEdge('B', 'C', false);
        graph.addEdge('B', 'E', false);
        graph.addEdge('B', 'D', false);
        graph.addEdge('B', 'F', false);
        graph.addEdge('B', 'G', false);
        graph.addEdge('B', 'I', false);
        graph.addEdge('B', 'X', false);
        graph.addEdge('C', 'F', false);
        graph.addEdge('C', 'E', false);
        graph.addEdge('C', 'D', false);
        graph.addEdge('C', 'H', false);
        graph.addEdge('C', 'X', false);
        graph.addEdge('C', 'X', false);
        graph.addEdge('C', 'X', false);
        graph.addEdge('D', 'E', false);
        graph.addEdge('D', 'G', false);
        graph.addEdge('D', 'H', false);
        graph.addEdge('D', 'I', false);
        graph.addEdge('D', 'X', false);
        graph.addEdge('E', 'F', false);
        graph.addEdge('E', 'G', false);
        graph.addEdge('E', 'H', false);
        graph.addEdge('E', 'I', false);
        graph.addEdge('F', 'G', false);
        graph.addEdge('F', 'H', false);
        graph.addEdge('F', 'I', false);
        graph.addEdge('F', 'X', false);
        graph.addEdge('G', 'H', false);
        graph.addEdge('G', 'X', false);
        graph.addEdge('G', 'X', false);
        graph.addEdge('G', 'X', false);
        graph.addEdge('H', 'I', false);
        graph.addEdge('H', 'X', false);
        graph.addEdge('I', 'X', false);
        graph.addEdge('I', 'X', false);
        graph.addEdge('I', 'X', false);

        graph.dfs(startChar, patternLength);
        return graph.getPatternCounter();
    }
}
