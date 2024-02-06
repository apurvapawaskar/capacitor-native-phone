import Foundation

@objc public class NativePhone: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
