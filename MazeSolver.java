import java.util.Stack;

/**
   Modify the maze solver program of Section 15.6.4 (below)
   to handle mazes with cycles.
   Keep a set of visited intersections.
   When you have previously seen an intersection, treat it
   as a dead end and do not add paths to the stack.
*/
public class MazeSolver
{
   /**
      Traverses a maze, printing out a path to the exit.
      @param maze the maze
      @param param the row of the starting position
      @param param the column of the starting position
   */
   public static void solve(Maze maze, int row, int column)
   {
      Stack<Path> s = new Stack<>();
      for (Path p : maze.pathsFrom(row, column))
      {
         s.push(p);
      }
// your code here

   }
}
