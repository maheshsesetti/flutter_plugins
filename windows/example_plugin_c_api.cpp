#include "include/example_plugin/example_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "example_plugin.h"

void ExamplePluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  example_plugin::ExamplePlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
