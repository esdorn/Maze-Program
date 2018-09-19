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
      Stack<Path> t = new Stack<>();
      Path path, path2 = new Path(0,0,0);
      while (!maze.isExit(s.peek().getEndingRow(),s.peek().getEndingColumn()))
      {
         path = s.pop();
         t.push(path);
         for (Path p : maze.pathsFrom(path.getEndingRow(), path.getEndingColumn()))
         {
             if (!path.isOpposite(p))
                s.push(p);
         }
      }
      path = s.pop();
      Stack<Path> d = new Stack<>();
      while (t.size()>0)
      {
          path2 = t.pop();
          if (path.getSColumn() == path2.getEndingColumn()&&path.getSRow() == path2.getEndingRow())
          {
              d.push(path);
              path=path2;
          }
      }
      d.push(path2);
      while (d.size()>0)
      {
          System.out.println(d.pop());
      }
   }
}
