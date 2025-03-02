import Foundation
import KMPSampleSwiftPackage

enum PriorityQueueUtil {
    static func pickMinimum(from array: [Int]) -> Int? {
        let pq = PriorityQueue<NSNumber>(
            comparator: { a, b in a.int32Value - b.int32Value }
        )
        array.forEach { pq.push(NSNumber(integerLiteral: $0)) }
        return pq.pop()?.intValue
    }
}
