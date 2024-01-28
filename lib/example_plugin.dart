
import 'example_plugin_platform_interface.dart';

class ExamplePlugin {
  Future<String?> getPlatformVersion() {
    return ExamplePluginPlatform.instance.getPlatformVersion();
  }

  Future showAlert() {
    return ExamplePluginPlatform.instance.showAlert();
  }
  Future showMap() {
    return ExamplePluginPlatform.instance.showMap();
  }
}
