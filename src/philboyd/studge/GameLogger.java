/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philboyd.studge;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tim
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
