import java.util.Stack;
import java.util.LinkedList;

/**
   Modify the maze solver program of Section 15.6.4 (below)
   to handle mazes with cycles.
   Keep a set of visited intersections.
   When you have previously seen an intersection, treat it
   as a dead end and do not add paths to the stack.
*/
public class MazeSolver {
	/**
     	Traverses a maze, printing out a path to the exit.
      	@param maze the maze
      	@param param the row of the starting position
      	@param param the column of the starting position
   	*/
   	public static void solve(Maze maze, int row, int column) {
     		Stack<Path> s = new Stack<>();
     		for (Path p : maze.pathsFrom(row, column))
     			{
       		 	s.push(p);
      		}

      		Path temp;
		LinkedList<Path> route = new LinkedList<>();

      		while (!s.isEmpty()) {
			temp = s.pop();
			System.out.println(temp);

			if (maze.isExit(temp.getEndingRow(), temp.getEndingColumn())) {
				break;
			}

			else {
				for (Path path : maze.pathsFrom(temp.getEndingRow(), temp.getEndingColumn())) {
					if (!path.isOpposite(temp)) {
						s.push(path);
						route.add(path);
					}
					
				}
				if (maze.pathsFrom(temp.getEndingRow(), temp.getEndingColumn()).size() == 0) route.remove(temp);
			}
		}

		for (Path read : route) System.out.println(read);
	}
}
