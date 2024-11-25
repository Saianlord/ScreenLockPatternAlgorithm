import java.util.*;

public class Graph {

    private Map<Character, List<Character>> adjList = new HashMap<>();
    private int patternCounter = 0;

    public void addVertex(char vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(char from, char to, boolean update) {
        if (!update) {
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        } else {
            int charIndex1 = findFirstOccurrence(adjList.getOrDefault(from, new ArrayList<>()), 'X');
            if (charIndex1 != -1) {
                adjList.getOrDefault(from, new ArrayList<>()).set(charIndex1, to);
            }

            int charIndex2 = findFirstOccurrence(adjList.getOrDefault(to, new ArrayList<>()), 'X');
            if (charIndex2 != -1) {
                adjList.getOrDefault(to, new ArrayList<>()).set(charIndex2, from);
            }
        }
    }

    private int findFirstOccurrence(List<Character> list, char charToFind) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == charToFind) {
                return i;
            }
        }
        return -1;
    }

    public void removeEdge(char from, char to, boolean update) {
        if (!update) {
            if (adjList.containsKey(from)) {
                adjList.get(from).remove(Character.valueOf(to));
            }
            if (adjList.containsKey(to)) {
                adjList.get(to).remove(Character.valueOf(from));
            }
        } else {
            int charIndex1 = findFirstOccurrence(adjList.getOrDefault(from, new ArrayList<>()), to);
            if (charIndex1 != -1) {
                adjList.getOrDefault(from, new ArrayList<>()).set(charIndex1, 'X');
            }

            int charIndex2 = findFirstOccurrence(adjList.getOrDefault(to, new ArrayList<>()), from);
            if (charIndex2 != -1) {
                adjList.getOrDefault(to, new ArrayList<>()).set(charIndex2, 'X');
            }
        }
    }

    public void dfs(char start, int patternLength) {
        Set<Character> visited = new HashSet<>();
        dfsRecursive(visited, start, 0, patternLength);
    }

    private void dfsRecursive(Set<Character> visited, char vertex, int nodeCounter, int patternLength) {
        Set<Character> processed = new HashSet<>();
        visited.add(vertex);
        nodeCounter++;

        updateTempConnections(vertex, false);

        for (char neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (nodeCounter == patternLength) {
                patternCounter++;
                break;
            }

            processed.add(neighbor);

            if (neighbor != 'X' && !visited.contains(neighbor) && nodeCounter < patternLength) {
                dfsRecursive(visited, neighbor, nodeCounter, patternLength);
            }
        }

        if (processed.containsAll(adjList.getOrDefault(vertex, new ArrayList<>())) || nodeCounter == patternLength) {
            updateTempConnections(vertex, true);
            visited.remove(vertex);
        }
    }

    private void updateTempConnections(char vertex, boolean processedVertex) {
        switch (vertex) {
            case 'B':
                if (!processedVertex) {
                    addEdge('A', 'C', true);
                } else {
                    removeEdge('A', 'C', true);
                }
                break;
            case 'D':
                if (!processedVertex) {
                    addEdge('A', 'G', true);
                } else {
                    removeEdge('A', 'G', true);
                }
                break;
            case 'F':
                if (!processedVertex) {
                    addEdge('C', 'I', true);
                } else {
                    removeEdge('C', 'I', true);
                }
                break;
            case 'H':
                if (!processedVertex) {
                    addEdge('G', 'I', true);
                } else {
                    removeEdge('G', 'I', true);
                }
                break;
            case 'E':
                if (!processedVertex) {
                    addEdge('A', 'I', true);
                    addEdge('B', 'H', true);
                    addEdge('C', 'G', true);
                    addEdge('D', 'F', true);
                } else {
                    removeEdge('A', 'I', true);
                    removeEdge('B', 'H', true);
                    removeEdge('C', 'G', true);
                    removeEdge('D', 'F', true);
                }
                break;
        }
    }

    public int getPatternCounter() {
        return patternCounter;
    }

    public void setPatternCounter(int patternCounter) {
        this.patternCounter = patternCounter;
    }
}
