@testable import KMPSampleIOSApp
import Testing

struct PriorityQueueUtilTest {
    @Test func pick() async throws {
        #expect(PriorityQueueUtil.pickMinimum(from: [1, 2, 5, 7, 10]) == 1)
    }
}
