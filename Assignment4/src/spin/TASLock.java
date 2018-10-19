/*
 * TASLock.java
 *
 * Created on January 20, 2006, 10:48 PM
 *
 * From "Multiprocessor Synchronization and Concurrent Data Structures",
 * by Maurice Herlihy and Nir Shavit.
 * Copyright 2006 Elsevier Inc. All rights reserved.
 */

package spin;

import edu.vt.ece.locks.*;
import edu.vt.ece.bench.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Test-and-set lock.
 * @author Maurice Herlihy
 */
public class TASLock implements Lock {
  AtomicBoolean state = new AtomicBoolean(false);
  public void lock() {
    while (state.getAndSet(true)) {} // spin
  }
  public void unlock() {
    state.set(false);
  }
}
