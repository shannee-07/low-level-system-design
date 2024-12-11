Designing a notify me system when the product will be available to purchase in ecommerce which is currently unavailable.

The Observer Pattern is a behavioral design pattern where an object (called the Subject) maintains a list of dependents (called Observers) and notifies them of any state changes. This ensures that when the state of the Subject changes, all dependent Observers are automatically updated.

### Simple Definition:
**Observable (Subject):**

Think of it as a notifier or a thing being watched.
It holds some important data or state that others (Observers) care about.
Whenever the data/state changes, it notifies all Observers about the change.

**Observer:**

These are the objects that want to be informed when the Observable changes.
They register themselves with the Observable to receive updates.
When notified, they can take action (e.g., display the updated data).
