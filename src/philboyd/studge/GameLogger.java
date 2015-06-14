/*
 * GameLogger 'console' queue
 * Yes, it's just a wrapped queue
 * One of the 'NINE ANTI-PATTERNS'
 */
package philboyd.studge;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author /u/Philboyd_Studge
 */
public class GameLogger
{
    private final Queue<String> log;
    
    public GameLogger()
    {
        log = new LinkedList<>();
    }
    
    public void clear()
    {
        log.clear();
    }
    
    public Queue<String> getLog()
    {
        return log;
    }
    
    public boolean isEmpty()
    {
        return log.isEmpty();
    }
    
    public void add(String input)
    {
        if (input.isEmpty()) return;
        log.add(input);
    }
    
    public String poll()
    {
        return log.poll();
    }
}
