import Foundation
import KMPSampleSwiftPackage

enum PriorityQueueUtil {
    private class PQItem {
        let value: Int
        init(value: Int) {
            self.value = value
        }
    }

    static func pickMinimum(from array: [Int]) -> Int? {
        let pq = PriorityQueue<PQItem>(
            comparator: { a, b in Int32(a.value - b.value) }
        )
        array.forEach { pq.push(PQItem(value: $0)) }
        return pq.pop()?.value
    }
}
