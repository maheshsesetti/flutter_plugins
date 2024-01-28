#ifndef FLUTTER_PLUGIN_EXAMPLE_PLUGIN_H_
#define FLUTTER_PLUGIN_EXAMPLE_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace example_plugin {

class ExamplePlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  ExamplePlugin();

  virtual ~ExamplePlugin();

  // Disallow copy and assign.
  ExamplePlugin(const ExamplePlugin&) = delete;
  ExamplePlugin& operator=(const ExamplePlugin&) = delete;

  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace example_plugin

#endif  // FLUTTER_PLUGIN_EXAMPLE_PLUGIN_H_
