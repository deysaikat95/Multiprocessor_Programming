/*
 * TTASLock.java
 *
 * Created on January 20, 2006, 10:59 PM
 *
 * From "Multiprocessor Synchronization and Concurrent Data Structures",
 * by Maurice Herlihy and Nir Shavit.
 * Copyright 2006 Elsevier Inc. All rights reserved.
 */

package spin;

/**
 * Test-and-test-and-set lock
 * @author Maurice Herlihy
 */

import edu.vt.ece.bench.*;
import edu.vt.ece.locks.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TTASLock implements Lock {
  AtomicBoolean state = new AtomicBoolean(false);
  public void lock() {
    while (true) {
      while (state.get()) {};  // spin
      if (!state.getAndSet(true))
        return;
    }
  }
  public void unlock() {
    state.set(false);
  }
}
