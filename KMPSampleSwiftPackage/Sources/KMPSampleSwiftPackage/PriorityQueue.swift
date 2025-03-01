import KMPSampleLibrary

public final class PriorityQueue<T: AnyObject> {
    private let comparator: (T, T) -> Int32
    private let pq: KMPSampleLibrary.PriorityQueue<T>

    public init(comparator: @escaping (T, T) -> Int32) {
        self.comparator = comparator
        pq = KMPSampleLibrary.PriorityQueue<T>(comparator: { a, b in
            // NOTE: The arguments of the comparator somehow becomes optional.
            KotlinInt(value: comparator(a!, b!))
        })
    }

    public func isEmpty() -> Bool {
        return pq.isEmpty()
    }

    public func size() -> Int32 {
        return pq.size()
    }

    public func peek() -> T? {
        return pq.peek()
    }

    public func push(_ element: T) {
        pq.push(element: element)
    }

    @discardableResult
    public func pop() -> T? {
        return pq.pop()
    }
}
